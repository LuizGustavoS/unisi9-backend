package br.com.si9.unisi9.orm;

import br.com.si9.unisi9.enumeration.TipoCliente;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cliente")
@EqualsAndHashCode(callSuper = true)
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

}
