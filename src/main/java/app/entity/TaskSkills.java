package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela TASKSKILLS
 * @generated
 */
@Entity
@Table(name = "\"TASKSKILLS\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.TaskSkills")
public class TaskSkills implements Serializable {

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
  @ManyToOne
  @JoinColumn(name="fk_task", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Task task;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_skill", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Skill skill;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_skillLevel", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private SkillLevel skillLevel;

  /**
   * Construtor
   * @generated
   */
  public TaskSkills(){
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
  public TaskSkills setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém task
   * return task
   * @generated
   */
  
  public Task getTask(){
    return this.task;
  }

  /**
   * Define task
   * @param task task
   * @generated
   */
  public TaskSkills setTask(Task task){
    this.task = task;
    return this;
  }

  /**
   * Obtém skill
   * return skill
   * @generated
   */
  
  public Skill getSkill(){
    return this.skill;
  }

  /**
   * Define skill
   * @param skill skill
   * @generated
   */
  public TaskSkills setSkill(Skill skill){
    this.skill = skill;
    return this;
  }

  /**
   * Obtém skillLevel
   * return skillLevel
   * @generated
   */
  
  public SkillLevel getSkillLevel(){
    return this.skillLevel;
  }

  /**
   * Define skillLevel
   * @param skillLevel skillLevel
   * @generated
   */
  public TaskSkills setSkillLevel(SkillLevel skillLevel){
    this.skillLevel = skillLevel;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    TaskSkills object = (TaskSkills)obj;
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
