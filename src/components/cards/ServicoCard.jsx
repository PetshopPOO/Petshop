export function ServicoCard({codigo, tipo, valor}){   
    return(
        <>
            <tr>
                <td>{codigo}</td>
                <td>{tipo}</td>
                <td>{valor}</td>
                <td><button className="btn btn-danger">Excluir</button></td>
            </tr>
        </>
    )
}