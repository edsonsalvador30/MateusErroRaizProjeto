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
 * Classe que representa a tabela SKILL
 * @generated
 */
@Entity
@Table(name = "\"SKILL\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Skill")
public class Skill implements Serializable {

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
  @Column(name = "skill", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String skill;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_skillCat", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private SkillCat skillCat;

  /**
  * @generated
  */
  @Column(name = "icon", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiCloud(type = "dropbox", value="9AFYR7pXfpAAAAAAAAAABac1LcdWqqVP8RhSdokIVDIXAKbJ_Z5z6JepOLvr5794")
  
  private java.lang.String icon;

  /**
   * Construtor
   * @generated
   */
  public Skill(){
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
  public Skill setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém skill
   * return skill
   * @generated
   */
  
  public java.lang.String getSkill(){
    return this.skill;
  }

  /**
   * Define skill
   * @param skill skill
   * @generated
   */
  public Skill setSkill(java.lang.String skill){
    this.skill = skill;
    return this;
  }

  /**
   * Obtém skillCat
   * return skillCat
   * @generated
   */
  
  public SkillCat getSkillCat(){
    return this.skillCat;
  }

  /**
   * Define skillCat
   * @param skillCat skillCat
   * @generated
   */
  public Skill setSkillCat(SkillCat skillCat){
    this.skillCat = skillCat;
    return this;
  }

  /**
   * Obtém icon
   * return icon
   * @generated
   */
  
  public java.lang.String getIcon(){
    return this.icon;
  }

  /**
   * Define icon
   * @param icon icon
   * @generated
   */
  public Skill setIcon(java.lang.String icon){
    this.icon = icon;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Skill object = (Skill)obj;
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
