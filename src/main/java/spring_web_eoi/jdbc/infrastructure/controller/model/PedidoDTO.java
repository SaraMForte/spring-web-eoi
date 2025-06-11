package spring_web_eoi.jdbc.infrastructure.controller.model;

import org.springframework.format.annotation.DateTimeFormat;
import spring_web_eoi.jdbc.domain.Order;

import java.time.LocalDate;

public class PedidoDTO {
    private int codigoPedido;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaPedido;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaEsperada;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaEntrega;
    private String estado;
    private String comentarios;
    private int codigoCliente;

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEsperada() {
        return fechaEsperada;
    }

    public void setFechaEsperada(LocalDate fechaEsperada) {
        this.fechaEsperada = fechaEsperada;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public static PedidoDTO fromDomain(Order order) {
        PedidoDTO dto = new PedidoDTO();
        dto.setCodigoPedido(order.orderCode());
        dto.setFechaPedido(order.orderDate());
        dto.setFechaEsperada(order.expectedDate());
        dto.setFechaEntrega(order.deliveryDate());
        dto.setEstado(order.status());
        dto.setComentarios(order.comment());
        dto.setCodigoCliente(order.clientCode());
        return dto;
    }

    public Order toDomain() {
        Order domain = new Order();
        domain.setOrderCode(this.getCodigoPedido());
        domain.setOrderDate(this.getFechaPedido());
        domain.setExpectedDate(this.getFechaEsperada());
        domain.setDeliveryDate(this.getFechaEntrega());
        domain.setStatus(this.getEstado());
        domain.setComment(this.getComentarios());
        domain.setClientCode(this.getCodigoCliente());
        return domain;
    }
}
