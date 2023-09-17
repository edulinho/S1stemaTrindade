/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.EtsProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eduardo
 */
public class ProdutoControle extends AbstractTableModel{
 
    List lista;

    public void setList(List lista){
    this.lista = lista;
    };
    public EtsProduto getBean(int row){
    return (EtsProduto)lista.get(row);
    }

    @Override
    public int getRowCount() {
       return 10;
    }

    @Override
    public int getColumnCount() {
return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {


      return "";
    }

    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "nome";
        }
        if (column == 2){
        return "validade";
        }
        if (column == 3){
        return "preço";
        }

        return "";
    };   
}
