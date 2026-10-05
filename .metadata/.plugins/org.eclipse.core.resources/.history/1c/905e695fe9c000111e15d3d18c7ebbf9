package br.com.portal.projeto.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.portal.projeto.entity.Prioridade;
import br.com.portal.projeto.entity.StatusAgendamento;
import br.com.portal.projeto.repository.PacienteRepository;
import br.com.portal.projeto.repository.ProfissionalRepository;
import br.com.portal.projeto.service.AgendamentoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {
	private final AgendamentoService service;
	private final PacienteRepository pacientes;
	private final ProfissionalRepository profissionais;

	@GetMapping
	String listar(Model m) {
		m.addAttribute("agendamentos", service.listar());
		return "agendamentos/lista";
	}

	@GetMapping("/novo")
	String novo(Model m) {
		formData(m);
		return "agendamentos/form";
	}

	@PostMapping("/salvar")
	String salvar(@RequestParam(required = false) Long id, @RequestParam Long pacienteId,
			@RequestParam Long profissionalId,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dataHora,
			@RequestParam String tipo, @RequestParam Prioridade prioridade,
			@RequestParam(required = false) String observacoes, RedirectAttributes ra) {
		service.salvar(id, pacienteId, profissionalId, dataHora, tipo, prioridade, observacoes);
		ra.addFlashAttribute("sucesso", "Agendamento salvo.");
		return "redirect:/agendamentos";
	}

	@PostMapping("/{id}/status")
	String status(@PathVariable Long id, @RequestParam StatusAgendamento status) {
		service.atualizarStatus(id, status);
		return "redirect:/agendamentos";
	}

	private void formData(Model m) {
		m.addAttribute("pacientes", pacientes.findAll());
		m.addAttribute("profissionais", profissionais.findByAtivoTrueOrderByNome());
		m.addAttribute("prioridades", Prioridade.values());
	}
}
