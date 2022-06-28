package br.com.DTO;

import java.io.Serializable;
import java.util.UUID;

import br.com.model.EquipmentStateEntity;

/**
 * Classe EquipmentStateDTO responsável pela transfêrencia de dados do objeto de maneira segura e eficiente
 * @author Danillo Santiago 
 * @since jun 2022
 */
public class EquipmentStateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4732553297573090956L;

	/**
	 * Atributo de identificação do estado de equipamento
	 */
	private UUID id;

	/**
	 * Atributo de nome do estado de equipamento
	 */
	private String nameState;

	/**
	 * Atributo de cor do estado de equipamento
	 */
	private String colorState;

	/**
	 * Método construtor responsável pela atribuição dos valores entre o DTO e a classe de persistência
	 * @param Objeto da classe EquipmentStateEntity
	 */
	public EquipmentStateDTO(EquipmentStateEntity stateEntity) {

		this.id = stateEntity.getId();
		this.nameState = stateEntity.getName();
		this.colorState = stateEntity.getColor();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}

	public String getColorState() {
		return colorState;
	}

	public void setColorState(String colorState) {
		this.colorState = colorState;
	}

}
