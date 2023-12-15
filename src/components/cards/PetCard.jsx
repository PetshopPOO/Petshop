export function PetCard({codigo, nome, especie, sexo, tutor}){   
    return(
        <>
            <tr>
                <td>{codigo}</td>
                <td>{nome}</td>
                <td>{especie}</td>
                <td>{sexo}</td>
                <td>{tutor}</td>
                <td><button className="btn btn-danger">Excluir</button></td>
            </tr>
        </>
    )
}