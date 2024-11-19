echo "Hello World!"
ls
dir
$resultado = ls
$resultado | ConvertTo-HTML | Out-File arq.html
$resultado | ConvertTo-CSV | Out-File arq.csv
$resultado | ConvertTo-JSON | Out-File arq.json