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
 * Classe que representa a tabela TASK
 * @generated
 */
@Entity
@Table(name = "\"TASK\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Task")
public class Task implements Serializable {

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
  @Column(name = "title", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String title;

  /**
  * @generated
  */
  @Column(name = "description", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String description;

  /**
  * @generated
  */
  @Column(name = "price", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.Double price;

  /**
  * @generated
  */
  @Column(name = "cronappuser_email", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String cronappuser_email;

  /**
  * @generated
  */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "assignmentDate", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.util.Date assignmentDate;

  /**
  * @generated
  */
  @Column(name = "document", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiCloud(type = "dropbox", value="9AFYR7pXfpAAAAAAAAAABac1LcdWqqVP8RhSdokIVDIXAKbJ_Z5z6JepOLvr5794")
  
  private java.lang.String document;

  /**
  * @generated
  */
  @Column(name = "status", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String status;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_project", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Project project;

  /**
   * Construtor
   * @generated
   */
  public Task(){
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
  public Task setId(java.lang.String id){
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
  public Task setTitle(java.lang.String title){
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
  public Task setDescription(java.lang.String description){
    this.description = description;
    return this;
  }

  /**
   * Obtém price
   * return price
   * @generated
   */
  
  public java.lang.Double getPrice(){
    return this.price;
  }

  /**
   * Define price
   * @param price price
   * @generated
   */
  public Task setPrice(java.lang.Double price){
    this.price = price;
    return this;
  }

  /**
   * Obtém cronappuser_email
   * return cronappuser_email
   * @generated
   */
  
  public java.lang.String getCronappuser_email(){
    return this.cronappuser_email;
  }

  /**
   * Define cronappuser_email
   * @param cronappuser_email cronappuser_email
   * @generated
   */
  public Task setCronappuser_email(java.lang.String cronappuser_email){
    this.cronappuser_email = cronappuser_email;
    return this;
  }

  /**
   * Obtém assignmentDate
   * return assignmentDate
   * @generated
   */
  
  public java.util.Date getAssignmentDate(){
    return this.assignmentDate;
  }

  /**
   * Define assignmentDate
   * @param assignmentDate assignmentDate
   * @generated
   */
  public Task setAssignmentDate(java.util.Date assignmentDate){
    this.assignmentDate = assignmentDate;
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
  public Task setDocument(java.lang.String document){
    this.document = document;
    return this;
  }

  /**
   * Obtém status
   * return status
   * @generated
   */
  
  public java.lang.String getStatus(){
    return this.status;
  }

  /**
   * Define status
   * @param status status
   * @generated
   */
  public Task setStatus(java.lang.String status){
    this.status = status;
    return this;
  }

  /**
   * Obtém project
   * return project
   * @generated
   */
  
  public Project getProject(){
    return this.project;
  }

  /**
   * Define project
   * @param project project
   * @generated
   */
  public Task setProject(Project project){
    this.project = project;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Task object = (Task)obj;
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
