/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.EtsVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eduardo
 */
public class vendasControle extends AbstractTableModel{
 List lista;

    public void setList(List lista){
    this.lista = lista;
     this.fireTableDataChanged();
    };
    public EtsVendas getBean(int row){
    return (EtsVendas)lista.get(row);
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
     EtsVendas etsVendas = (EtsVendas) lista.get(rowIndex);
        if (columnIndex == 0){
        return etsVendas.getEtsIdvendas();
        }
        if (columnIndex == 1){
        return etsVendas.getEtsQuantidade();
        }
        if (columnIndex == 2){
        return etsVendas.getEtsTotal();
        }
      if (columnIndex == 3 && etsVendas.getEtsVendendor()!= null){
        return etsVendas.getEtsVendendor().getEtsIdvendendor();
      }
        return "";
    }

    @Override
    public String getColumnName(int column){
        if (column == 0){
        return "id";
        }
        if (column == 1){
        return "quantidade";
        }
        if (column == 2){
        return "total";
        }
        if (column == 3){
        return "codigo do vendendor";
        }

        return "";
    };   
}
