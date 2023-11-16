/*
 
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/
package view;

import bean.EtsUsuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.EtsUsuario;

/**
 *
 
@author carlo*/
public class UsuarioControle  extends AbstractTableModel{

    List lista;

    public void setList(List lista){
    this.lista = lista;
    this.fireTableDataChanged();
    };
    public EtsUsuario getBean(int row){
    return (EtsUsuario)lista.get(row);
    }

    @Override
    public int getRowCount() {
 return lista.size();
    }

    @Override
    public int getColumnCount() {
return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
EtsUsuario etsUsuario = (EtsUsuario) lista.get(rowIndex);
        if (columnIndex == 0){
        return etsUsuario.getEtsIdusuario();
        }
        if (columnIndex == 1){
        return etsUsuario.getEtsNome();
        }
        if (columnIndex == 2){
        return etsUsuario.getEtsApelido();
        }
        if (columnIndex == 3){
        return etsUsuario.getEtsCpf();
        }
        return "";    }

    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "nome";
        }
        if (column == 2){
        return "apelido";
        }
        if (column == 3){
        return "cpf";
        }

        return "";
    };
}