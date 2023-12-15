import { useVendaData } from "../hooks/venda/useVendaData";
import { VendaCard } from "./cards/VendaCard";
import '../static/form.css'
import { Link } from "react-router-dom";


export function Venda(){
    const { data } = useVendaData();
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h1>vendas</h1>
            <table>
                <tr>
                    <th>Código</th>
                    <th>Cliente</th>
                    <th>Funcionário</th>
                    <th>Ações</th>
                </tr>
                {data?.map(venda =>
                    <VendaCard 
                        codigo={venda.codigo}
                        cliente={venda.cliente?.nome}
                        funcionario={venda.funcionario?.nome}/>)}
            </table>
        </>
    )
}