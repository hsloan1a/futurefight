import React from 'react'
import {Character} from "../shadowland/model/Character";

type CharactersProps = {
    character: Character,
    addCharacter: (argv0: Character) => void
}

const CharacterTableDetail = (props: CharactersProps) => {
    return(
        <tr key={props.character.id} onClick={() => props.addCharacter(props.character)}>
            <td>{props.character.name}</td>
            <td>{props.character.affinity}</td>
            <td>{props.character.gender}</td>
            <td>{props.character.side}</td>
        </tr>
    )
};

export default CharacterTableDetail;