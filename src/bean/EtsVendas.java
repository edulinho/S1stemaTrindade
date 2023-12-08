package bean;
// Generated 07/12/2023 21:49:12 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EtsVendas generated by hbm2java
 */
@Entity
@Table(name="ets_vendas"
    ,catalog="lp"
)
public class EtsVendas  implements java.io.Serializable {


     private int etsIdvendas;
     private EtsCliente etsCliente;
     private EtsVendendor etsVendendor;
     private Date etsData;
     private Double etsTotal;

    public EtsVendas() {
    }

	
    public EtsVendas(int etsIdvendas, EtsCliente etsCliente, EtsVendendor etsVendendor, Date etsData, Double etsTotal) {
        this.etsIdvendas = etsIdvendas;
        this.etsCliente = etsCliente;
        this.etsVendendor = etsVendendor;
        this.etsData = etsData;
        this.etsTotal = etsTotal;
    }
   
     @Id 

    
    @Column(name="ets_idvendas", unique=true, nullable=false)
    public int getEtsIdvendas() {
        return this.etsIdvendas;
    }
    
    public void setEtsIdvendas(int etsIdvendas) {
        this.etsIdvendas = etsIdvendas;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ets_fkcliente", nullable=false)
    public EtsCliente getEtsCliente() {
        return this.etsCliente;
    }
    
    public void setEtsCliente(EtsCliente etsCliente) {
        this.etsCliente = etsCliente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ets_fkvendendor", nullable=false)
    public EtsVendendor getEtsVendendor() {
        return this.etsVendendor;
    }
    
    public void setEtsVendendor(EtsVendendor etsVendendor) {
        this.etsVendendor = etsVendendor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ets_data", nullable=false, length=10)
    public Date getEtsData() {
        return this.etsData;
    }
    
    public void setEtsData(Date etsData) {
        this.etsData = etsData;
    }

    
    @Column(name="ets_total", nullable=false, precision=10)
    public Double getEtsTotal() {
        return this.etsTotal;
    }
    
    public void setEtsTotal(Double etsTotal) {
        this.etsTotal = etsTotal;
    }

}

