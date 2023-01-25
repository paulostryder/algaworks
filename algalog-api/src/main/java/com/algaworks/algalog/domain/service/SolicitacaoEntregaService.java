package com.algaworks.algalog.domain.service;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	
	
	
	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregaRepository;
	

	public SolicitacaoEntregaService(CatalogoClienteService catalogoClienteService,
			EntregaRepository entregaRepository) {
		super();
		this.catalogoClienteService = catalogoClienteService;
		this.entregaRepository = entregaRepository;
	}


		
	
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		
		return entregaRepository.save(entrega);
	}

	

}
