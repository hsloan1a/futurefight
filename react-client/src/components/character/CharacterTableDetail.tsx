import React from 'react'
import {Character} from "../shadowland/model/Character";

type CharactersProps = {
    characterList: Array<Character>
}

const CharacterTableDetail = (props: CharactersProps) => {
    return(
        <>
            {props.characterList.map(character => {
            return (
                <tr key={character.id}>
                    <td>{character.name}</td>
                    <td>{character.affinity}</td>
                    <td>{character.gender}</td>
                    <td>{character.side}</td>
                </tr>
            )
        })}
            </>
    )
};

export default CharacterTableDetail;