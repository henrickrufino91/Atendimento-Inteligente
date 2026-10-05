package br.com.portal.projeto.service;

import br.com.portal.projeto.entity.*;
import br.com.portal.projeto.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service @RequiredArgsConstructor
public class ConvenioService {
 private final ConvenioRepository convenios; private final PacienteConvenioRepository vinculos; private final PacienteRepository pacientes;
 public List<Convenio> listar(){return convenios.findAllByOrderByNomeAsc();}
 public List<Convenio> ativos(){return convenios.findByAtivoTrueOrderByNomeAsc();}
 public Convenio buscar(Long id){return convenios.findById(id).orElseThrow();}
 @Transactional public Convenio salvar(Long id,String nome,String ans,String telefone,String email,boolean ativo){ Convenio c=id==null?new Convenio():buscar(id);c.setNome(nome);c.setRegistroAns(ans);c.setTelefone(telefone);c.setEmail(email);c.setAtivo(ativo);return convenios.save(c);}
 public List<PacienteConvenio> doPaciente(Long pacienteId){return vinculos.findByPacienteIdOrderByConvenioNomeAsc(pacienteId);}
 public List<PacienteConvenio> ativosDoPaciente(Long pacienteId){return vinculos.findByPacienteIdAndAtivoTrueOrderByConvenioNomeAsc(pacienteId).stream().filter(PacienteConvenio::isValido).toList();}
 public PacienteConvenio buscarVinculo(Long id){return vinculos.findById(id).orElseThrow();}
 @Transactional public PacienteConvenio vincular(Long pacienteId,Long convenioId,String plano,String carteirinha,String titular,LocalDate validade){ return vinculos.save(PacienteConvenio.builder().paciente(pacientes.findById(pacienteId).orElseThrow()).convenio(buscar(convenioId)).plano(plano).numeroCarteirinha(carteirinha).titular(titular).validade(validade).ativo(true).build()); }
 @Transactional public void alternar(Long id){var v=buscarVinculo(id);v.setAtivo(!v.isAtivo());vinculos.save(v);}
 public PacienteConvenio validarVinculo(Long id,Long pacienteId){ if(id==null)throw new IllegalArgumentException("Selecione o convênio/plano do paciente."); var v=buscarVinculo(id); if(!Objects.equals(v.getPaciente().getId(),pacienteId))throw new IllegalArgumentException("O convênio selecionado não pertence ao paciente."); if(!v.isValido())throw new IllegalArgumentException("O convênio selecionado está inativo ou vencido."); return v; }
}
