import openpyxl

book=openpyxl.load_workbook('Planilhas de compras.xlsx')
frutas_page=book['Frutas']

for rows in frutas_page.iter_rows(min_row=2,max_row=5):
    for cell in rows:
        if cell.value=='Teste1':
            cell.value='Frutas'
            book.save('Planilhas de compras.xlsx')
        #print(rows[0].value,rows[1].value,rows[2].value)
        #print(cell.value)