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
 * Classe que representa a tabela USERSKILLS
 * @generated
 */
@Entity
@Table(name = "\"USERSKILLS\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.UserSkills")
public class UserSkills implements Serializable {

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
  @JoinColumn(name="fk_skill", nullable = false, referencedColumnName = "id", insertable=true, updatable=true)
  
  private Skill skill;

  /**
  * @generated
  */
  @Column(name = "attachment", nullable = true, unique = false, insertable=true, updatable=true)
  @CronapiCloud(type = "dropbox", value="nownu5UgiJAAAAAAAAAAB3WIJx1-szMwBAcOKxuiqrP4Ee355jETd5B4PP9FoVxi")
  
  private java.lang.String attachment;

  /**
  * @generated
  */
  @ManyToOne
  @JoinColumn(name="fk_user", nullable = true, referencedColumnName = "id", insertable=true, updatable=true)
  
  private User user;

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
  public UserSkills(){
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
  public UserSkills setId(java.lang.String id){
    this.id = id;
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
  public UserSkills setSkill(Skill skill){
    this.skill = skill;
    return this;
  }

  /**
   * Obtém attachment
   * return attachment
   * @generated
   */
  
  public java.lang.String getAttachment(){
    return this.attachment;
  }

  /**
   * Define attachment
   * @param attachment attachment
   * @generated
   */
  public UserSkills setAttachment(java.lang.String attachment){
    this.attachment = attachment;
    return this;
  }

  /**
   * Obtém user
   * return user
   * @generated
   */
  
  public User getUser(){
    return this.user;
  }

  /**
   * Define user
   * @param user user
   * @generated
   */
  public UserSkills setUser(User user){
    this.user = user;
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
  public UserSkills setSkillLevel(SkillLevel skillLevel){
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
    UserSkills object = (UserSkills)obj;
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
