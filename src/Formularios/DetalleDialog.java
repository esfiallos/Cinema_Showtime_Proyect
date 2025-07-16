package Formularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetalleDialog extends JDialog {

    private boolean confirmado = false;

    private JComboBox<String> comboBoleto;
    private JComboBox<String> comboAsiento;
    private JTextField txtCantidad;

    public DetalleDialog(Frame parent, java.util.List<String> boletos, java.util.List<String> asientos) {
        super(parent, "Agregar Detalle", true);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Boleto:"));
        comboBoleto = new JComboBox<>(boletos.toArray(new String[0]));
        add(comboBoleto);

        add(new JLabel("Asiento:"));
        comboAsiento = new JComboBox<>(asientos.toArray(new String[0]));
        add(comboAsiento);

        add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField("1");
        add(txtCantidad);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> {
            if (validar()) {
                confirmado = true;
                setVisible(false);
            }
        });
        add(btnAceptar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> {
            confirmado = false;
            setVisible(false);
        });
        add(btnCancelar);

        pack();
        setLocationRelativeTo(parent);
    }

    private boolean validar() {
        if (txtCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese cantidad");
            return false;
        }
        try {
            int cant = Integer.parseInt(txtCantidad.getText().trim());
            if (cant <= 0) {
                JOptionPane.showMessageDialog(this, "Cantidad debe ser mayor a cero");
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cantidad debe ser un número válido");
            return false;
        }
        return true;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public String getBoletoSeleccionado() {
        return (String) comboBoleto.getSelectedItem();
    }

    public String getAsientoSeleccionado() {
        return (String) comboAsiento.getSelectedItem();
    }

    public int getCantidad() {
        return Integer.parseInt(txtCantidad.getText().trim());
    }
}