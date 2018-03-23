package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela SKILLLEVEL
 * @generated
 */
@Entity
@Table(name = "\"SKILLLEVEL\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.SkillLevel")
public class SkillLevel implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "level", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String level;

  /**
  * @generated
  */
  @Column(name = "active", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Boolean active = true;

  /**
   * Construtor
   * @generated
   */
  public SkillLevel(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public SkillLevel setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém level
   * return level
   * @generated
   */
  
  public java.lang.String getLevel(){
    return this.level;
  }

  /**
   * Define level
   * @param level level
   * @generated
   */
  public SkillLevel setLevel(java.lang.String level){
    this.level = level;
    return this;
  }

  /**
   * Obtém active
   * return active
   * @generated
   */
  
  public java.lang.Boolean getActive(){
    return this.active;
  }

  /**
   * Define active
   * @param active active
   * @generated
   */
  public SkillLevel setActive(java.lang.Boolean active){
    this.active = active;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    SkillLevel object = (SkillLevel)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
