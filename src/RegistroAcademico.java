/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mikim
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistroAcademico extends JFrame {

    JTextField txtNombre, txtMatricula, txtCarrera;
    JTextField txtPracticas, txtParciales, txtAsignaciones, txtExamen;
    JLabel lblResultado;

    public RegistroAcademico() {

        setTitle("Registro Académico");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(10, 2, 5, 5));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        add(txtMatricula);

        add(new JLabel("Carrera:"));
        txtCarrera = new JTextField();
        add(txtCarrera);

        add(new JLabel("Prácticas:"));
        txtPracticas = new JTextField();
        add(txtPracticas);

        add(new JLabel("Parciales:"));
        txtParciales = new JTextField();
        add(txtParciales);

        add(new JLabel("Asignaciones):"));
        txtAsignaciones = new JTextField();
        add(txtAsignaciones);

        add(new JLabel("Examen Final:"));
        txtExamen = new JTextField();
        add(txtExamen);

        JButton btnCalcular = new JButton("Calcular Resultado");
        add(btnCalcular);

        lblResultado = new JLabel("");
        add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    double practicas = Double.parseDouble(txtPracticas.getText());
                    double parciales = Double.parseDouble(txtParciales.getText());
                    double asignaciones = Double.parseDouble(txtAsignaciones.getText());
                    double examen = Double.parseDouble(txtExamen.getText());

                    if(practicas < 0 || practicas > 40 ||
                       parciales < 0 || parciales > 20 ||
                       asignaciones < 0 || asignaciones > 20 ||
                       examen < 0 || examen > 20) {

                        JOptionPane.showMessageDialog(null,
                                "Las notas están fuera del rango permitido.");
                        return;
                    }

                    double total = practicas + parciales +
                                  asignaciones + examen;

                    String estado = (total >= 60)
                            ? "APROBADO"
                            : "REPROBADO";

                    lblResultado.setText(
                            "Nota Final: " + total +
                            " - " + estado);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Ingrese solamente números en las calificaciones.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new RegistroAcademico().setVisible(true);
    }
}