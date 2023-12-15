import { useFuncionarioData } from "../hooks/funcionario/useFuncionarioData"
import { FuncionarioCard } from "./cards/FuncionarioCard";
import '../static/form.css'
import { Link } from "react-router-dom";

export function Funcionario(){
    const { data } = useFuncionarioData();
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h1>Funcionários</h1>
            <table>
                <tr>
                    <th>Cpf</th>
                    <th>Nome</th>
                    <th>Telefones</th>
                    <th>Rg</th>
                    <th>Matrícula</th>
                    <th>Salário</th>
                    <th>Rua</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Ações</th>
                </tr>
                {data?.map(funcionario =>
                    <FuncionarioCard 
                        cpf={funcionario.cpf}
                        nome={funcionario.nome}
                        telefones={funcionario.telefones}
                        rg={funcionario.rg}
                        matricula={funcionario.matricula}
                        salario={funcionario.salario}
                        rua={funcionario.rua}
                        bairro={funcionario.bairro}
                        cidade={funcionario.cidade}/>)}
            </table>
        </>
    )
}