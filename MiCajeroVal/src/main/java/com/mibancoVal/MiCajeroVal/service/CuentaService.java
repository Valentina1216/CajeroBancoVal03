package com.mibancoVal.MiCajeroVal.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import java.util.List;
import com.mibancoVal.MiCajeroVal.entity.Cuenta;
import com.mibancoVal.MiCajeroVal.entity.TipoCuenta;
import com.mibancoVal.MiCajeroVal.repository.CuentaRepository;
import com.mibancoVal.MiCajeroVal.entity.Cliente;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaService {
    private final CuentaRepository cuentaRepository;

    public Cuenta crearCuenta(Cliente cliente, 
    String numero, TipoCuenta tipo, double saldo) {
        Cuenta cuenta = Cuenta.builder()
        .cliente(null)
        .numero(numero)
        .tipo(tipo)
        .saldo(saldo)
        .build();
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> buscarPorNumero(String numero) {
        return cuentaRepository.findfindByNumero(numero);
    }

    public double consultarSaldo(Cuenta cuenta) {
        return cuenta.getSaldo();
    }

    public List<Cuenta> obtenerCuentasCliente(Cliente cliente) {
        return cliente.getCuentas();
    }

    public void actualizarSaldo(Cuenta cuenta, double nuevoSaldo) {
        cuenta.setSaldo(nuevoSaldo);
        cuentaRepository.save(cuenta);
    }

    public List<Cuenta> buscarPorCliente(Cliente cliente) {
        return cuentaRepository.finfindByCliente(cliente); //findByCliente

    }

    public Cuenta obtenerCuentaPorClienteActual (String username) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
