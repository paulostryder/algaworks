package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {
	
	private EntregaRepository entregaRepository;
	private BuscaEntregaService buscaEntregaService;	
	
	public FinalizacaoEntregaService(EntregaRepository entregaRepository, BuscaEntregaService buscaEntregaService) {
		super();
		this.entregaRepository = entregaRepository;
		this.buscaEntregaService = buscaEntregaService;
	}

	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega =  buscaEntregaService.buscar(entregaId);
		entrega.finalizar();		
		
		entregaRepository.save(entrega); 
		
		}
		
	}
