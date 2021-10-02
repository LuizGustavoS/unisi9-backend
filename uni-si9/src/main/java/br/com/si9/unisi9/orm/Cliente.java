package br.com.si9.unisi9.orm;

import br.com.si9.unisi9.enumeration.TipoCliente;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente", allocationSize = 1)
public class Cliente extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "id_cliente", unique = true, updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cliente")
    private Integer idCliente;

    @Column(name = "ds_nome", nullable = false, length = 100)
    private String dsNome;

    @Column(name = "ds_cpf", nullable = false, length = 14)
    private String dsCpf;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_cliente", nullable = false)
    private TipoCliente tipoCliente;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getDsNome() {
        return dsNome;
    }

    public void setDsNome(String dsNome) {
        this.dsNome = dsNome;
    }

    public String getDsCpf() {
        return dsCpf;
    }

    public void setDsCpf(String dsCpf) {
        this.dsCpf = dsCpf;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
