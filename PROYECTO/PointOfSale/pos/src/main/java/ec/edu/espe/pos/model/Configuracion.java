package ec.edu.espe.pos.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "POS_CONFIGURACION")
public class Configuracion implements Serializable {

    @EmbeddedId
    private ConfiguracionPK pk;
    @NotNull
    @Column(name = "DIRECCION_MAC", length = 32, nullable = false)
    private String direccionMac;
    @NotNull
    @Column(name = "CODIGO_COMERCIO", nullable = false)
    private Integer codigoComercio;
    @NotNull
    @Column(name = "FECHA_ACTIVACION", nullable = false)
    private LocalDateTime fechaActivacion;

    @Transient
    private String codigoComercioPOS;

    public Configuracion() {
    }

    public Configuracion(ConfiguracionPK pk) {
        this.pk = pk;
    }

    public ConfiguracionPK getPk() {
        return pk;
    }

    public void setPk(ConfiguracionPK pk) {
        this.pk = pk;
    }

    public String getDireccionMac() {
        return direccionMac;
    }

    public void setDireccionMac(String direccionMac) {
        this.direccionMac = direccionMac;
    }

    public Integer getCodigoComercio() {
        return codigoComercio;
    }

    public void setCodigoComercio(Integer codigoComercio) {
        this.codigoComercio = codigoComercio;
    }

    public LocalDateTime getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(LocalDateTime fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Configuracion other = (Configuracion) obj;
        if (pk == null) {
            if (other.pk != null)
                return false;
        } else if (!pk.equals(other.pk))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "POSConfiguracion [pk=" + pk + ", direccionMac=" + direccionMac + ", codigoComercio=" + codigoComercio
                + ", fechaActivacion=" + fechaActivacion + "]";
    }

}