package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela SKILLCAT
 * @generated
 */
@Entity
@Table(name = "\"SKILLCAT\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.SkillCat")
public class SkillCat implements Serializable {

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
  @Column(name = "category", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String category;

  /**
   * Construtor
   * @generated
   */
  public SkillCat(){
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
  public SkillCat setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém category
   * return category
   * @generated
   */
  
  public java.lang.String getCategory(){
    return this.category;
  }

  /**
   * Define category
   * @param category category
   * @generated
   */
  public SkillCat setCategory(java.lang.String category){
    this.category = category;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    SkillCat object = (SkillCat)obj;
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
