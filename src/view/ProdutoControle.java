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
    this.fireTableDataChanged();
    };
    
    public EtsProduto getBean(int row){
    return (EtsProduto)lista.get(row);
    }

    @Override
    public int getRowCount() {
       return lista.size();
    }

    @Override
    public int getColumnCount() {
return 4;
    }
    
    public void updateBean(int index, EtsProduto etsProduto){ 
        lista.set(index, etsProduto);
        this.fireTableDataChanged();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

EtsProduto produto = (EtsProduto) lista.get(rowIndex);
        if (columnIndex == 0){
        return produto.getEtsIdProduto();
        }
        if (columnIndex == 1){
        return produto.getEtsNome();
        }
        if (columnIndex == 2){
        return produto.getEtsPreco();
        }
        if (columnIndex == 3){
        return produto.getEtsValidade();
        }
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
        return "preço";
        }
        if (column == 3){
        return "validade";
        }

        return "";
    };   
}
