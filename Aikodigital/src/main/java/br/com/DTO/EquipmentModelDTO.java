package br.com.DTO;

import java.io.Serializable;
import java.util.UUID;

import br.com.model.EquipmentModelEntity;

/**
 * Classe EquipmentModelDTO responsável pela transfêrencia de dados do objeto de maneira segura e eficiente
 * @author Danillo Santiago
 * @since jun 2022
 */
public class EquipmentModelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4523323404988817442L;

	/**
	 * Atributo de identificação da classe do tipo UUID
	 */
	private UUID id;

	/**
	 * Nome  do modelo de equipamento
	 */
	private String modelName;

	/**
	 * Método construtor responsável pela atribuição dos valores entre o DTO e a classe de persistência
	 * @param Objeto da classe EquipmentModelEntity
	 */
	public EquipmentModelDTO(EquipmentModelEntity modelEntity) {
		this.id = modelEntity.getId();
		this.modelName = modelEntity.getName();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelName() {
		return modelName;
	}

}
