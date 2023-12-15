export function ClienteCard({cpf, nome, telefones, email, rua, bairro, cidade}){   
    return(
        <>
            <tr>
                <td>{cpf}</td>
                <td>{nome}</td>
                <td>{telefones}</td>
                <td>{email}</td>
                <td>{rua}</td>
                <td>{bairro}</td>
                <td>{cidade}</td>
                <td><button className="btn btn-danger">Excluir</button></td>
            </tr>
        </>
    )
}