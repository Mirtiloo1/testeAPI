package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import org.example.entity.agenda;
import org.example.service.agendaService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/agenda")

public class agendaController {
    @Autowired
    private agendaService agendaService;
    @PostMapping
    @ResponseStatus(CREATED)
    public agenda save(@RequestBody @Valid agenda agenda){
        return agendaService.salvar(agenda);
    }

    @GetMapping(value = "{id}")
    public Optional<agenda> listar(@PathVariable("id") Integer id){

        return agendaService.listar(id);

//        if (product != null) {
//            return new ResponseEntity<ProductBean>(product, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<ProductBean>(HttpStatus.NOT_FOUND);
//        }
    }

    @GetMapping
    public List<agenda> listarTodos(){
        return agendaService.listar();
    }

    @GetMapping(value="teste")
    public String teste() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                //.uri(URI.create("http://localhost:8080/api/agenda/"))
                .uri(URI.create("https://randomuser.me/api/"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
