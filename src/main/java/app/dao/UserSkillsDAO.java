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
@Repository("UserSkillsDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface UserSkillsDAO extends JpaRepository<UserSkills, java.lang.String> {

  /**
   * Obtém a instância de UserSkills utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM UserSkills entity WHERE entity.id = :id")
  public UserSkills findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de UserSkills utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM UserSkills entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);



  /**
   * Foreign Key skill
   * @generated
   */
  @Query("SELECT entity FROM UserSkills entity WHERE entity.skill.id = :id")
  public Page<UserSkills> findUserSkillssBySkill(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key user
   * @generated
   */
  @Query("SELECT entity FROM UserSkills entity WHERE entity.user.id = :id")
  public Page<UserSkills> findUserSkillssByUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * Foreign Key skillLevel
   * @generated
   */
  @Query("SELECT entity FROM UserSkills entity WHERE entity.skillLevel.id = :id")
  public Page<UserSkills> findUserSkillssBySkillLevel(@Param(value="id") java.lang.String id, Pageable pageable);

}
