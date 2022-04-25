package com.suellenoliveiraprog.aikoprova.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.suellenoliveiraprog.aikoprova.model.Equipament;
import com.suellenoliveiraprog.aikoprova.model.exceptions.ResourceNotFoundException;
import com.suellenoliveiraprog.aikoprova.repository.EquipamentRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipamentServices {
    
    @Autowired
    private EquipamentRepository equipamentRepository;

    //Consulta Todos os equipamentos
    public List<Equipament> consultarTodosEquipamentos(){
        
        List<Equipament> equipaments = equipamentRepository.findAll();

        return equipaments;
    }

    //Consulta Equipamento por ID
    public Optional<Equipament> consultarEquipamentosPorID(UUID id){
        
        Optional<Equipament> equipaments = equipamentRepository.findById(id);

        if(equipaments.isEmpty()){
            throw new ResourceNotFoundException("Produto com ID: "+ id + " não localizado!");
        }

        return equipaments;
    }

    //Adicionar Equipamento
    public Equipament adicionarEquipamento(Equipament equipamentAdc){
        //Removendo o ID para realizar o cadastro.
        //equipamentAdc.setId(null);
        
        //Salvando o equipamento no banco.
        Equipament equipaments = new ModelMapper().map(equipamentAdc, Equipament.class);
        equipaments = equipamentRepository.save(equipaments);
        equipamentAdc.setName(equipaments.getName());

        //Retornando equipamento.
        return equipamentAdc;

    }

    //Atualizar Equipamento
    public Equipament atualizarEquipamento(Equipament equipamentAtz, UUID id){
        //Localizando o Equipamento pelo Id.
        equipamentAtz.setId(id);
        
        //Salvando a atualização no banco.
        Equipament equipaments = new ModelMapper().map(equipamentAtz, Equipament.class);
        equipaments = equipamentRepository.save(equipaments);

        //Retornando atualizado.
        return equipamentAtz;

    }

    //Deletando o Equipamento
    public void deletarEquipamento(UUID id){
        //Verificando se o produto existe
        Optional<Equipament> equipaments = equipamentRepository.findById(id);

        //se não encontrar lança exception
        if(equipaments.isEmpty()){
            throw new ResourceNotFoundException("Produto com ID: "+ id + " não localizado!");
        }

        equipamentRepository.deleteById(id);     
    }
}
