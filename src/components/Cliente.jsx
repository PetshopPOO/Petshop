import { useClienteData } from "../hooks/cliente/useClienteData"
import { ClienteCard } from "./cards/ClienteCard"
import '../static/form.css'
import { Link } from "react-router-dom";

export function Cliente(){
    const { data } = useClienteData();
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h1>Clientes</h1>
            <table>
                <tr>
                    <th>Cpf</th>
                    <th>Nome</th>
                    <th>Telefones</th>
                    <th>Email</th>
                    <th>Rua</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Ações</th>
                </tr>
                {data?.map(cliente =>
                    <ClienteCard 
                        cpf={cliente.cpf}
                        nome={cliente.nome}
                        telefones={cliente.telefones}
                        email={cliente.email}
                        rua={cliente.rua}
                        bairro={cliente.bairro}
                        cidade={cliente.cidade}/>)}
            </table>
        </>
    )
}