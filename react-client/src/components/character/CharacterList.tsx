import React from 'react'
import {ButtonGroup, Button, DropdownButton, Dropdown, Table} from 'react-bootstrap';
import {Character} from "../shadowland/model/Character";
import axios from "axios";
import {map, uniq} from "underscore";
import CharacterTableDetail from "./Character";

type CharacterListProps = {
    characterList: Array<Character>
}


class CharacterList extends React.Component<any,any> {
    state = {
        allCharacters: []
    }

    componentDidMount = (): void => {
        axios.get(process.env.REACT_APP_APP_BACKEND_BASEURL + 'characters/characters').then((response) => {
            if (response.data) {
                let characterList = uniq(map(response.data._embedded.marvelCharacterList, (character: Character) => {return character}));
                console.log("app", characterList);
                this.setState({allCharacters: characterList});

            }
        })
    }
    render() {
        const {allCharacters} = this.state;
        return (
            <div>
                <ButtonGroup>
                    <Button>All</Button>
                    <Button>Blast</Button>
                    <Button>Combat</Button>
                    <Button>Speed</Button>
                    <Button>Universal</Button>
                </ButtonGroup>

                <DropdownButton as={ButtonGroup} title="Dropdown" id="bg-nested-dropdown">
                    <Dropdown.Item eventKey="1">Dropdown link</Dropdown.Item>
                    <Dropdown.Item eventKey="2">Dropdown link</Dropdown.Item>
                </DropdownButton>
                <Table striped bordered hover variant="dark">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Affinity</th>
                        <th>Gender</th>
                        <th>Side</th>
                    </tr>
                    </thead>
                    <tbody>
                    {allCharacters && <CharacterTableDetail characterList={allCharacters} />}
                    </tbody>
                </Table>
            </div>
        )
    }

}
export default CharacterList;
