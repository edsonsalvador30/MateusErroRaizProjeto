package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("SkillDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface SkillDAO extends JpaRepository<Skill, java.lang.String> {

  /**
   * Obtém a instância de Skill utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Skill entity WHERE entity.id = :id")
  public Skill findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Skill utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Skill entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM UserSkills entity WHERE entity.skill.id = :id")
  public Page<UserSkills> findUserSkills(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM TaskSkills entity WHERE entity.skill.id = :id")
  public Page<TaskSkills> findTaskSkills(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key skillCat
   * @generated
   */
  @Query("SELECT entity FROM Skill entity WHERE entity.skillCat.id = :id")
  public Page<Skill> findSkillsBySkillCat(@Param(value="id") java.lang.String id, Pageable pageable);

}
