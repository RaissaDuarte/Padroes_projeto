package com.example.projeto1.model;

public class Pedido implements Cloneable{
    private String pedido;
    private int mesa;

    public Pedido(int mesa, String pedido){
        this.pedido = pedido;
        this.mesa = mesa;
    }

    // public Pedido(){

    // }

    public String getPedido(){
        return pedido;
    }
    public int getMesa(){
        return mesa;
    }

    public void setPedido(String pe){
        pedido = pe;
    }

    @Override
    public Pedido clone() throws CloneNotSupportedException {
        return (Pedido) super.clone();
    }
    

}
