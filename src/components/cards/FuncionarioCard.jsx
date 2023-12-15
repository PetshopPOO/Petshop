export function FuncionarioCard({cpf, nome, telefones, rg, matricula, salario, rua, bairro, cidade}){   
    return(
        <>
            <tr>
                <td>{cpf}</td>
                <td>{nome}</td>
                <td>{telefones}</td>
                <td>{rg}</td>
                <td>{matricula}</td>
                <td>{salario}</td>
                <td>{rua}</td>
                <td>{bairro}</td>
                <td>{cidade}</td>
                <td><button className="btn btn-danger">Excluir</button></td>
            </tr>
        </>
    )
}