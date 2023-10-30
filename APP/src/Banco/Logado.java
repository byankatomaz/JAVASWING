package Banco;

import Componentes.Frame;
import Entidades.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Logado {
    Frame frames;

    public Logado(Frame frames){
        this.frames = frames;
    }

    public Usuario usuarioLogado(Object[] results){

        Usuario usuario = new Usuario();

        String email = (String) results[0];
        String senha = (String) results[1];
        String nome = (String) results[2];
        Integer idUser = (Integer) results[3];

        usuario.setNome(nome);
        usuario.setId(idUser);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        frames.setUsuario(usuario);

        System.out.println("ENTROU");
        System.out.println("Você é o " + nome);

        return usuario;
    }


}
