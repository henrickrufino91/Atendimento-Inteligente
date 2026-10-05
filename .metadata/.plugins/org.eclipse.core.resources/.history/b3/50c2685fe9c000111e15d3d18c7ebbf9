package br.com.portal.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.portal.projeto.dto.UsuarioForm;
import br.com.portal.projeto.service.RbacService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/usuarios")
@RequiredArgsConstructor
public class AdminUsuarioController {
	private final RbacService rbac;

	@GetMapping
	public String lista(Model m) {
		m.addAttribute("usuarios", rbac.listarUsuarios());
		return "admin/usuarios/lista";
	}

	@GetMapping("/novo")
	public String novo(Model m) {
		preparar(m, UsuarioForm.builder().ativo(true).build());
		return "admin/usuarios/form";
	}

	@GetMapping("/{id}/editar")
	public String editar(@PathVariable Long id, Model m) {
		preparar(m, rbac.formUsuario(rbac.obterUsuario(id)));
		return "admin/usuarios/form";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid @ModelAttribute("form") UsuarioForm form, BindingResult br, Model m,
			RedirectAttributes ra) {
		if (br.hasErrors()) {
			preparar(m, form);
			return "admin/usuarios/form";
		}
		try {
			rbac.salvarUsuario(form);
			ra.addFlashAttribute("sucesso", "Usuário salvo com sucesso.");
			return "redirect:/admin/usuarios";
		} catch (IllegalArgumentException e) {
			m.addAttribute("erro", e.getMessage());
			preparar(m, form);
			return "admin/usuarios/form";
		}
	}

	private void preparar(Model m, UsuarioForm form) {
		m.addAttribute("form", form);
		m.addAttribute("perfis", rbac.listarPerfis());
	}
}
