package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;
import cronapi.CronapiCloud;


/**
 * Classe que representa a tabela PROJECT
 * @generated
 */
@Entity
@Table(name = "\"PROJECT\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Project")
public class Project implements Serializable {

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
  @Column(name = "title", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String title;

  /**
  * @generated
  */
  @Column(name = "description", nullable = false, unique = false, insertable=true, updatable=true)
  
  private java.lang.String description;

  /**
  * @generated
  */
  @Column(name = "document", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiCloud(type = "dropbox", value="9AFYR7pXfpAAAAAAAAAABac1LcdWqqVP8RhSdokIVDIXAKbJ_Z5z6JepOLvr5794")
  
  private java.lang.String document;

  /**
   * Construtor
   * @generated
   */
  public Project(){
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
  public Project setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém title
   * return title
   * @generated
   */
  
  public java.lang.String getTitle(){
    return this.title;
  }

  /**
   * Define title
   * @param title title
   * @generated
   */
  public Project setTitle(java.lang.String title){
    this.title = title;
    return this;
  }

  /**
   * Obtém description
   * return description
   * @generated
   */
  
  public java.lang.String getDescription(){
    return this.description;
  }

  /**
   * Define description
   * @param description description
   * @generated
   */
  public Project setDescription(java.lang.String description){
    this.description = description;
    return this;
  }

  /**
   * Obtém document
   * return document
   * @generated
   */
  
  public java.lang.String getDocument(){
    return this.document;
  }

  /**
   * Define document
   * @param document document
   * @generated
   */
  public Project setDocument(java.lang.String document){
    this.document = document;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Project object = (Project)obj;
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
