package br.com.portal.projeto.controller;

import br.com.portal.projeto.service.ConvenioService;
import br.com.portal.projeto.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;

@Controller @RequiredArgsConstructor
public class ConvenioController {
 private final ConvenioService service; private final PacienteService pacientes;
 @GetMapping("/convenios") String listar(Model m){m.addAttribute("convenios",service.listar());return "convenios/lista";}
 @GetMapping("/convenios/novo") String novo(Model m){m.addAttribute("convenio",null);return "convenios/form";}
 @GetMapping("/convenios/{id}/editar") String editar(@PathVariable Long id,Model m){m.addAttribute("convenio",service.buscar(id));return "convenios/form";}
 @PostMapping("/convenios/salvar") String salvar(@RequestParam(required=false)Long id,@RequestParam String nome,@RequestParam(required=false)String registroAns,@RequestParam(required=false)String telefone,@RequestParam(required=false)String email,@RequestParam(defaultValue="false")boolean ativo,RedirectAttributes ra){service.salvar(id,nome,registroAns,telefone,email,ativo);ra.addFlashAttribute("sucesso","Convênio salvo.");return "redirect:/convenios";}
 @GetMapping("/pacientes/{pacienteId}/convenios") String paciente(@PathVariable Long pacienteId,Model m){m.addAttribute("paciente",pacientes.buscar(pacienteId));m.addAttribute("vinculos",service.doPaciente(pacienteId));m.addAttribute("convenios",service.ativos());return "convenios/paciente";}
 @PostMapping("/pacientes/{pacienteId}/convenios") String vincular(@PathVariable Long pacienteId,@RequestParam Long convenioId,@RequestParam String plano,@RequestParam String numeroCarteirinha,@RequestParam(required=false)String titular,@RequestParam(required=false)@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate validade,RedirectAttributes ra){service.vincular(pacienteId,convenioId,plano,numeroCarteirinha,titular,validade);ra.addFlashAttribute("sucesso","Convênio vinculado ao paciente.");return "redirect:/pacientes/"+pacienteId+"/convenios";}
 @PostMapping("/pacientes/{pacienteId}/convenios/{id}/alternar") String alternar(@PathVariable Long pacienteId,@PathVariable Long id){service.alternar(id);return "redirect:/pacientes/"+pacienteId+"/convenios";}
}
