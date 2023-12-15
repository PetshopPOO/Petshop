import { useServicoData } from "../hooks/servico/useServicoData";
import { ServicoCard } from "./cards/ServicoCard";
import '../static/form.css'
import { Link } from "react-router-dom";

export function Servico(){
    const { data } = useServicoData();
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h1>sevicos</h1>
            <table>
                <tr>
                    <th>Código</th>
                    <th>Tipo</th>
                    <th>Valor</th>
                    <th>Ações</th>
                </tr>
                {data?.map(sevico =>
                    <ServicoCard 
                        codigo={sevico.codigo}
                        tipo={sevico.tipo}
                        valor={sevico.valor}/>)}
            </table>
        </>
    )
}