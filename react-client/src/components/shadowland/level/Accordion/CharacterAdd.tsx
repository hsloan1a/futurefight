import React from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

type CharacterAdd = {
    characterName: string
}

export const CharacterAdd = (props: CharacterAdd) => {
    return (
        <div>
            <Card >
                <Card.Body>
                    <Card.Title>{props.characterName}</Card.Title>

                    <Button variant="primary">Remove</Button>
                </Card.Body>
            </Card>
        </div>
    )
}