package com.suellenoliveiraprog.aikoprova.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.suellenoliveiraprog.aikoprova.model.EquipamentModel;
import com.suellenoliveiraprog.aikoprova.model.exceptions.ResourceNotFoundException;
import com.suellenoliveiraprog.aikoprova.repository.EquipamentModelRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentModelServices {
    @Autowired
    private EquipamentModelRepository equipamentModelRepository;

    //Consultar Todos os modelos de equipamentos
    public List<EquipamentModel> consultarTodosModelosEquipamentos(){
        
        List<EquipamentModel> equipamentsModel = equipamentModelRepository.findAll();

        return equipamentsModel;
    }

    //Consulta Modelo de Equipamento por ID
    public Optional<EquipamentModel> consultarEquipamentosPorID(UUID id){
        
        Optional<EquipamentModel> equipaments = equipamentModelRepository.findById(id);

        if(equipaments.isEmpty()){
            throw new ResourceNotFoundException("Produto com ID: "+ id + " não localizado!");
        }

        return equipaments;
    }

    //Adicionar Modelo de Equipamento
    public EquipamentModel adicionarEquipamento(EquipamentModel equipamentModelAdc){
        //Removendo o ID para realizar o cadastro.
        equipamentModelAdc.setId(null);
        
        //Salvando o equipamento no banco.
        EquipamentModel equipaments = new ModelMapper().map(equipamentModelAdc, EquipamentModel.class);
        equipaments = equipamentModelRepository.save(equipaments);
        equipamentModelAdc.setId(equipaments.getId());

        //Retornando equipamento.
        return equipamentModelAdc;

    }

    //Atualizar Modelo de Equipamento
    public EquipamentModel atualizarEquipamento(EquipamentModel equipamentModelAtz, UUID id){
        //Localizando o Equipamento pelo Id.
        equipamentModelAtz.setId(id);
        
        //Salvando a atualização no banco.
        EquipamentModel equipaments = new ModelMapper().map(equipamentModelAtz, EquipamentModel.class);
        equipaments = equipamentModelRepository.save(equipaments);

        //Retornando atualizado.
        return equipamentModelAtz;

    }

    //Deletando o Modelo do Equipamento
    public void deletarEquipamento(UUID id){
        //Verificando se o produto existe
        Optional<EquipamentModel> equipaments = equipamentModelRepository.findById(id);

        //se não encontrar lança exception
        if(equipaments.isEmpty()){
            throw new ResourceNotFoundException("Produto com ID: "+ id + " não localizado!");
        }

        equipamentModelRepository.deleteById(id);     
    }
}
