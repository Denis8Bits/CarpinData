package datacoins.CarpinData.web.controller;

import datacoins.CarpinData.dominio.dto.CategoriaDto;
import datacoins.CarpinData.dominio.dto.ModCategoriaDto;
import datacoins.CarpinData.dominio.service.CategoriaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@ViewScoped
public class WebCategoriaController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(WebCategoriaController.class);

    @Autowired
    private CategoriaService categoriaService;

    private List<CategoriaDto> categorias;
    private CategoriaDto categoriaSeleccionada;

    // Campos para el formulario de creación/edición
    private String editNombre;
    private String editDescripcion;
    private String editEstado; // Para el estado, podrías usar un SelectOneMenu con 'ACTIVE' y 'INACTIVE'

    // Constructor vacío requerido por JSF/Spring
    public WebCategoriaController() {
    }

    // Constructor con Autowired (opcional si usas @Autowired en el campo)
    public WebCategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    /**
     * Carga todas las categorías desde el servicio.
     */
    public void cargarDatos() {
        try {
            this.categorias = this.categoriaService.obtenerTodo();
            logger.info("Categorías cargadas: " + this.categorias.size());
        } catch (Exception e) {
            logger.error("Error al cargar las categorías", e);
            this.categorias = new ArrayList<>();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudieron cargar las categorías."));
        }
    }

    /**
     * Prepara el diálogo para crear una nueva categoría.
     */
    public void agregarCategoria() {
        this.categoriaSeleccionada = null;
        this.editNombre = "";
        this.editDescripcion = "";
        this.editEstado = "ACTIVE"; // Estado por defecto
        PrimeFaces.current().executeScript("PF('ventanaModalCategoria').show()");
    }

    /**
     * Prepara el diálogo para editar una categoría existente.
     * @param c La CategoriaDto a editar.
     */
    public void prepararEdicion(CategoriaDto c) {
        this.categoriaSeleccionada = c;
        if (c != null) {
            this.editNombre = c.nombre();
            this.editDescripcion = c.descripcion();
            this.editEstado = c.estado();
        }
        PrimeFaces.current().executeScript("PF('ventanaModalCategoria').show()");
    }

    /**
     * Guarda (crea o modifica) la categoría.
     */
    public void guardarCategoria() {
        try {
            CategoriaDto categoriaGuardada;
            String mensajeExito;

            if (this.categoriaSeleccionada == null || this.categoriaSeleccionada.id() == null) {
                // Lógica para CREAR
                CategoriaDto nuevaDto = new CategoriaDto(null, editNombre, editDescripcion, editEstado);
                categoriaGuardada = this.categoriaService.guardarCategotis(nuevaDto); // Asumo 'guardarCategotis' es un typo y es 'guardarCategoria'
                mensajeExito = "Categoría Agregada";
            } else {
                // Lógica para MODIFICAR
                ModCategoriaDto modDto = new ModCategoriaDto(this.categoriaSeleccionada.id(), editNombre, editDescripcion, editEstado);
                categoriaGuardada = this.categoriaService.modificarCategoria(this.categoriaSeleccionada.id(), modDto);
                mensajeExito = "Categoría Modificada";
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensajeExito));
            cargarDatos(); // Recargar la tabla
            this.categoriaSeleccionada = categoriaGuardada;
            PrimeFaces.current().ajax().update("formCategorias:tablaCategorias", "growlMensajes");
            PrimeFaces.current().executeScript("PF('ventanaModalCategoria').hide()");
            this.categoriaSeleccionada = null; // Limpiar para el próximo uso

        } catch (Exception e) {
            logger.error("Error al guardar/modificar categoría", e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage() != null ? e.getMessage() : "No se pudo guardar la categoría."));
            PrimeFaces.current().ajax().update("growlMensajes");
        }
    }

    /**
     * Elimina la categoría seleccionada.
     */
    public void eliminarCategoria() {
        if (this.categoriaSeleccionada == null || this.categoriaSeleccionada.id() == null) return;
        try {
            this.categoriaService.eliminarCategoria(this.categoriaSeleccionada.id());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Categoría Eliminada"));
            cargarDatos(); // Recargar la tabla
            PrimeFaces.current().ajax().update("formCategorias:tablaCategorias", "growlMensajes");
            this.categoriaSeleccionada = null;
        } catch (Exception e) {
            logger.error("Error al eliminar categoría", e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage() != null ? e.getMessage() : "No se pudo eliminar la categoría."));
            PrimeFaces.current().ajax().update("growlMensajes");
        }
    }

    /**
     * Cierra el diálogo de creación/edición.
     */
    public void cancelarCategoria() {
        this.categoriaSeleccionada = null;
        PrimeFaces.current().executeScript("PF('ventanaModalCategoria').hide()");
    }
}