package net.evdokimov.spring.account;

import net.evdokimov.spring.account.Account;
import net.evdokimov.spring.account.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping(value = "/account")
public class AccountController {
    private Map<Long, Account> accounts = new ConcurrentHashMap<>();

    @RequestMapping(method = RequestMethod.GET)
    public String getCreateFrom(Model model) {
        model.addAttribute(new Account());
        return "account/createFrom";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Account account, Errors result) {
        if (result.hasErrors()) {
            return "account/createFrom";
        }
        this.accounts.put(account.assignId(), account);
        return "redirect:/account/" + account.getId();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getView(@PathVariable Long id, Model model) {
        Account account = this.accounts.get(id);
        if (account == null) {
            throw new ResourceNotFoundException(id);
        }
        model.addAttribute(account);
        return "account/view";
    }
}
