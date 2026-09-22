package com.springproject1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject1.Entity.Mensaje;
import com.springproject1.Repository.MensajeRepository;

import jakarta.annotation.PostConstruct;

@RestController
public class MensajeController {
    private final MensajeRepository repo;

    public MensajeController(MensajeRepository repo) {
        this.repo = repo;
    }

    @PostConstruct //Esta anotacion le dice a Spring que ejecute el metodo automaticamente despues de crear este objeto
    public void init(){
        if(repo.count()== 0){
            Mensaje m = new Mensaje();
            m.setTexto("Hola mundo desde la base de datos en la nube");
            repo.save(m); //Esto guarda en la base de datos PERO JPA normalmente no lo ejecuta al isntante. Trabaja con "transaccion" normalmente se ejecuta y se envia a la bd al hacer flush o finalizar la transaccion
        }
    }

    @GetMapping("/") //Cuando se haga una peticion HTTP GET a la direccion "/" ejecuta este metodo
    public String hola(){
        return repo.findAll().get(0).getTexto(); //findAll devuelve una lista. get() es el metodo para coger elemnto cocnreto de una lista, en nuestro caso un objeto Mensaje
    }

}
