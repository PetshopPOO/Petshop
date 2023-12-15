import { useFornecedorData } from "../hooks/fornecedor/useFornecedorData";
import { FornecedorCard } from "./cards/FornecedorCard";
import '../static/form.css'
import { Link } from "react-router-dom";

export function Fornecedor(){
    const { data } = useFornecedorData();
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h1>Fornecedors</h1>
            <table>
                <tr>
                    <th>Cnpj</th>
                    <th>Nome</th>
                    <th>Telefones</th>
                    <th>Rua</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Ações</th>
                </tr>
                {data?.map(fornecedor =>
                    <FornecedorCard 
                        cnpj={fornecedor.cnpj}
                        nome={fornecedor.nome}
                        telefones={fornecedor.telefones}
                        rua={fornecedor.rua}
                        bairro={fornecedor.bairro}
                        cidade={fornecedor.cidade}/>)}
            </table>
        </>
    )
}