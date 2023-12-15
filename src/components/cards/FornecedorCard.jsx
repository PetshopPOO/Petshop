export function FornecedorCard({cnpj, nome, telefones, rua, bairro, cidade}){   
    return(
        <>
            <tr>
                <td>{cnpj}</td>
                <td>{nome}</td>
                <td>{telefones}</td>
                <td>{rua}</td>
                <td>{bairro}</td>
                <td>{cidade}</td>
                <td><button className="btn btn-danger">Excluir</button></td>
            </tr>
        </>
    )
}